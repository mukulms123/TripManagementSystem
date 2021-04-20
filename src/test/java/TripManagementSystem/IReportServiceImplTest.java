package TripManagementSystem;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.ReportNotFoundException;
import com.cg.tms.service.IReportServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IReportServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IReportServiceImplTest {

	public Report  addReport(Report report) {
		return null;
	}
	public Report  deleteReport(int reportId) throws ReportNotFoundException {
		return null;
	}
	public Report  viewReport(int reportId) throws ReportNotFoundException {
		return null;
	}
	public Report  viewAllReports() {
		return null;
	}
}
