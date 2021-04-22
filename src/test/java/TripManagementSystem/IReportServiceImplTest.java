package TripManagementSystem;

import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doNothing;

import java.util.List;
import java.util.Optional;
import com.cg.tms.entities.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.ReportNotFoundException;
import com.cg.tms.repository.IReportRepository;
import com.cg.tms.service.IReportService;
import com.cg.tms.service.IReportServiceImpl;

@ExtendWith({MockitoExtension.class})
public class IReportServiceImplTest {

	@Mock
	IReportRepository rRep;
	
	@Spy
	@InjectMocks
	IReportServiceImpl rService;
	
	@Test
	public void addReport() {
		Report report = new Report("ABC","DEF");
		Report saved = mock(Report.class);
		when(rRep.save(report)).thenReturn(saved);
		Report result = rService.addReport(report);
		Assertions.assertNotNull(result);
		Assertions.assertSame(saved,result);
		verify(rRep).save(report);
	}
	
	@Test
	public void deleteReport() throws ReportNotFoundException {
		int id=1;
		Report report = mock(Report.class);
		Optional<Report> opt = Optional.of(report);
		when(rRep.findById(id)).thenReturn(opt);
		doNothing().when(rRep).delete(report);
		Report report2 = rService.deleteReport(id);
		Assertions.assertNotNull(opt);
		Assertions.assertEquals(report,report2);
		verify(rRep).delete(report2);	
	}
	
	@Test
	public void viewReport() throws ReportNotFoundException {
		int id=1;
		Report rep = mock(Report.class);
		Optional<Report> opt = Optional.of(rep);
		when(rRep.findById(id)).thenReturn(opt);
		Report result = rService.viewReport(id);
		Assertions.assertNotNull(result);
		Assertions.assertSame(rep,result);
	}
	
	@Test
	public void viewAllReports() {
		List<Report> reportss = mock(List.class);
		when(rRep.findAll()).thenReturn(reportss);
		List<Report> result=rRep.findAll();
		Assertions.assertSame(reportss, result);
		verify(rRep).findAll();
	}
}
