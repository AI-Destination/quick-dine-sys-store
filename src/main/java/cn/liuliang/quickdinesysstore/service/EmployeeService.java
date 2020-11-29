package cn.liuliang.quickdinesysstore.service;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Employee;
import cn.liuliang.quickdinesysstore.entity.vo.EmployeeQueryVO;
import cn.liuliang.quickdinesysstore.entity.vo.EmployeeVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 添加或修改员工
     * @param employeeVO 员工信息对象
     * @return
     */
    ResultDTO addOrUpdate(EmployeeVO employeeVO);

    /**
     * 分页查询所有员工列表
     * @param pageNum           当前页
     * @param pageSize          每页大小
     * @param employeeQueryVO   查询条件数据
     * @return
     */
    ResultDTO selectAll(Integer pageNum, Integer pageSize, EmployeeQueryVO employeeQueryVO);

    /**
     * 根据员工id查询详情
     * @param id    员工id
     * @return
     */
    ResultDTO selectOne(Long id);
}
