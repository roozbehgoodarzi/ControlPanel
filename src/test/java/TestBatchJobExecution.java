import com.ocs.entity.BatchJobExecution;
import com.ocs.spring.service.BatchJobExecutionService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Goodarzi on 06/15/2015.
 */
public class TestBatchJobExecution extends TestCase {
    public void testBatchJobExecutionFetch(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        BatchJobExecutionService batchJobExecutionService = (BatchJobExecutionService) ctx.getBean("BatchJobExecutionService");
        BatchJobExecution batchJobExecution = batchJobExecutionService.getBatchJobExecutionById(1L);
        System.out.println("batchJobExecution.getStatus() = " + batchJobExecution.getStatus());
        System.out.println("batchJobExecution.getBatchStepExecutions().get(0) = " + batchJobExecution.getBatchStepExecutions().get(0));
        System.out.println("batchJobExecution.getJobExecutionParams().get(0) = " + batchJobExecution.getJobExecutionParams().get(0));
    }

    public void testFetchAllBatchJobExecutions(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        BatchJobExecutionService batchJobExecutionService = (BatchJobExecutionService) ctx.getBean("BatchJobExecutionService");
        List<BatchJobExecution> batchJobExecutions = batchJobExecutionService.getAllBatchJobExecutions();
        for (BatchJobExecution batchJobExecution : batchJobExecutions) {
            System.out.println("batchJobExecution.getJobInstanceId() = " + batchJobExecution.getJobInstanceId());
        }
    }
    public void testFetchByStatus(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        BatchJobExecutionService batchJobExecutionService = (BatchJobExecutionService) ctx.getBean("BatchJobExecutionService");
        List<BatchJobExecution> batchJobExecutions = batchJobExecutionService.getAllBatchExecutionsByStatus("1");
    }

    public void testFetchBatchJobExecutionsByStartDateAndBranch(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        BatchJobExecutionService batchJobExecutionService = (BatchJobExecutionService) ctx.getBean("BatchJobExecutionService");
        Timestamp timestamp = Timestamp.valueOf("2015-07-01 15:54:14");
        List<BatchJobExecution> batchJobExecutions = batchJobExecutionService.getBatchJobExecutionsByStartDateAndBranch(timestamp,"COMPLETED","CODE", "1185");
        for (BatchJobExecution batchJobExecution : batchJobExecutions) {
            System.out.println("batchJobExecution.getCreateTime() = " + batchJobExecution.getCreateTime());
        }
    }
}
