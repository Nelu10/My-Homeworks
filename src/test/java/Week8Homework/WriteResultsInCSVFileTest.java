package Week8Homework;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.mockito.Mockito.*;

class WriteResultsInCSVFileTest {

    @Test
    void testWriteDataToCSVFile() {
        AthletesRanking mockRanking = mock(AthletesRanking.class);
        Athlete mockAthlete = mock(Athlete.class);

        when(mockAthlete.getAthleteNumber()).thenReturn(1);
        when(mockAthlete.getAthleteName()).thenReturn("John Doe");
        when(mockAthlete.getAthleteCountryCode()).thenReturn("USA");
        when(mockAthlete.getSkiTimeResult()).thenReturn("30:00");

        when(mockAthlete.getFirstShootingResults()).thenReturn(new ShootingResults[]{ShootingResults.HIT, ShootingResults.MISS});
        when(mockAthlete.getSecondShootingResults()).thenReturn(new ShootingResults[]{ShootingResults.HIT, ShootingResults.HIT});
        when(mockAthlete.getThirdShootingResults()).thenReturn(new ShootingResults[]{ShootingResults.MISS, ShootingResults.HIT});
        when(mockRanking.getAthletes()).thenReturn(Arrays.asList(mockAthlete));
        WriteResultsInCSVFile.writeDataToCSVFile(mockRanking);
        verify(mockRanking, times(2)).getAthletes();
        verify(mockAthlete, times(1)).getAthleteNumber();
    }
}