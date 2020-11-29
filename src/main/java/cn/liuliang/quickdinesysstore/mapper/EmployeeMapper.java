package cn.liuliang.quickdinesysstore.mapper;

import cn.liuliang.quickdinesysstore.entity.Employee;
import cn.liuliang.quickdinesysstore.entity.vo.EmployeeQueryVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 根据条件分页查询员工信息
     *
     * @param employeePage    分页对象
     * @param employeeQueryVO 查询条件对象
     * @return
     */
    List<Employee> selectAll(@Param("employeePage") Page<Employee> employeePage, @Param("employeeQueryVO") EmployeeQueryVO employeeQueryVO);

}
