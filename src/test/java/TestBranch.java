import com.ocs.entity.Branch;
import com.ocs.entity.FetchResult;
import com.ocs.spring.service.BranchService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Goodarzi on 06/14/2015.
 */
public class TestBranch extends TestCase {
    public void testBranchInsert() {
        Branch branch = new Branch();
        branch.setCode(1708L);
        branch.setName("DolatST");
        branch.setUserName("omid");
        branch.setAutomaticFlag(Short.valueOf("1"));
        branch.setIp("10.104.99.2");
        branch.setPath("no path");
        branch.setfName("خیابان دولت");
        branch.setAreaCode(Short.valueOf("21"));

        ApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        BranchService branchService = (BranchService) ctx.getBean("BranchService");

        branchService.addBranch(branch);
        System.out.println("inserted..");
    }

    public void testGetBranch() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        BranchService branchService = (BranchService) ctx.getBean("BranchService");

        Branch branch = branchService.getBranchByCode(1708L);
        System.out.println("branch.getName = " + branch.getName());
        System.out.println("branch.getfName() = " + branch.getfName());
    }

    public void testFetchBranchByParmeter() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        BranchService branchService = (BranchService) ctx.getBean("BranchService");

        Branch branch = branchService.getBranchByParameter("name", "ardebil");
        System.out.println("branch.getName = " + branch.getName());
        System.out.println("branch.getfName() = " + branch.getfName());
    }

    public void testDeleteBranch() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        BranchService branchService = (BranchService) ctx.getBean("BranchService");
        Branch branch = new Branch();
        branch.setCode(1708L);
        branchService.deleteBranch(branch);
        System.out.println("deleted .. ");
    }

    public void testFetchBranchesWithPagination() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        BranchService branchService = (BranchService) ctx.getBean("BranchService");
        List<Branch> branches = branchService.getBranchesWithPagination(0, 10, "", null);
        for (Branch branch : branches) {
            System.out.println("branch.getName() = " + branch.getName());
        }
        System.out.println("=====================================");
        branches = branchService.getBranchesWithPagination(null, null, "name", true);
        for (Branch branch : branches) {
            System.out.println("branch.getName() = " + branch.getName());
        }
        System.out.println("=====================================");
        branches = branchService.getBranchesWithPagination(0, 10, "name", false);
        for (Branch branch : branches) {
            System.out.println("branch.getName() = " + branch.getName());
        }
    }

    public void testFetchBranchesWithPaginationAndRowCount() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        BranchService branchService = (BranchService) ctx.getBean("BranchService");
        final Long totalCount = null;
        FetchResult<Branch> branches = branchService.getBranchesFetchResulyWithPagination(0, 10, "", null);
        System.out.println("totalCount" + branches.getCount());
        for (Branch branch : branches.getResults()) {
            System.out.println("branch.getName() = " + branch.getName());
        }
        System.out.println("=====================================");
        branches = branchService.getBranchesFetchResulyWithPagination(null, 20, "name", true);
        for (Branch branch : branches.getResults()) {
            System.out.println("branch.getName() = " + branch.getName());
        }
        System.out.println("=====================================");
        branches = branchService.getBranchesFetchResulyWithPagination(0, 10, "name", false);
        for (Branch branch : branches.getResults())
            System.out.println("branch.getName() = " + branch.getName());
    }
}

