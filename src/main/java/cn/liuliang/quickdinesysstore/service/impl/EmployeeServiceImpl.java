package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.base.result.ResultCodeEnum;
import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Employee;
import cn.liuliang.quickdinesysstore.entity.Level;
import cn.liuliang.quickdinesysstore.entity.dto.EmployeeDTO;
import cn.liuliang.quickdinesysstore.entity.dto.EmployeeDetailDTO;
import cn.liuliang.quickdinesysstore.entity.dto.LevelDTO;
import cn.liuliang.quickdinesysstore.entity.dto.LevelIdAndNameDTO;
import cn.liuliang.quickdinesysstore.entity.vo.EmployeeQueryVO;
import cn.liuliang.quickdinesysstore.entity.vo.EmployeeVO;
import cn.liuliang.quickdinesysstore.exception.QuickException;
import cn.liuliang.quickdinesysstore.mapper.EmployeeMapper;
import cn.liuliang.quickdinesysstore.mapper.LevelMapper;
import cn.liuliang.quickdinesysstore.service.EmployeeService;
import cn.liuliang.quickdinesysstore.service.LevelService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private LevelMapper levelMapper;

    @Autowired
    private LevelService levelService;

    @Override
    public ResultDTO addOrUpdate(EmployeeVO employeeVO) {
        // 判断必要参数是否为空
        if (StringUtils.isEmpty(employeeVO.getEmployeeName()) ||
                StringUtils.isEmpty(employeeVO.getLevelId()) ||
                StringUtils.isEmpty(employeeVO.getPassword()) ||
                StringUtils.isEmpty(employeeVO.getEntryTime())) {
            throw new QuickException(ResultCodeEnum.PAEAMETER_IS_EMPTY);
        }
        // 构造插入或修改数据
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeVO, employee);
        // 格式化入职时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            employee.setEntryTime(simpleDateFormat.parse(employeeVO.getEntryTime()));
        } catch (ParseException e) {
            throw new QuickException("时间格式转换异常",8001);
        }
        // 判断是添加还是修改
        if (null == employeeVO.getId()) {
            // 添加
            return ResultDTO.success("data", employeeMapper.insert(employee));
        }
        // 修改
        return ResultDTO.success("data", employeeMapper.updateById(employee));
    }

    @Override
    public ResultDTO selectAll(Integer pageNum, Integer pageSize, EmployeeQueryVO employeeQueryVO) {
        // 构造分页对象
        Page<Employee> employeePage = new Page<>(pageNum, pageSize);
        // 执行查询
        List<Employee> employeeList = employeeMapper.selectAll(employeePage, employeeQueryVO);
        // 构造返回数据
        List<EmployeeDTO> employeeDTOList = new ArrayList<>(employeeList.size());
        employeeList.forEach(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employee, employeeDTO);
            employeeDTOList.add(employeeDTO);
        });
        // 获取所有员工级别名称和id列表
        List<LevelIdAndNameDTO> levelIdAndNameDTOList = (List<LevelIdAndNameDTO>) levelService.getAllLevelIdAndName().getData().get("data");
        // 将结果编程map便于获取数据
        Map<Long, String> levelIdAndNameMap = new HashMap<>(levelIdAndNameDTOList.size());
        // 给map填充数据
        levelIdAndNameDTOList.forEach(levelIdAndNameDTO -> {
            levelIdAndNameMap.put(levelIdAndNameDTO.getId(), levelIdAndNameDTO.getLevelName());
        });
        // 给员工列表填充缺失的级别字段
        employeeDTOList.forEach(employeeDTO -> {
            employeeDTO.setLevelName(levelIdAndNameMap.get(employeeDTO.getLevelId()));
        });
        return ResultDTO.success().data("total", Math.toIntExact(employeePage.getTotal())).data("rows", employeeDTOList);
    }

    @Override
    public ResultDTO selectOne(Long id) {
        // 根据id查询员工信息
        Employee employee = employeeMapper.selectById(id);
        // 根据员工的级别id查询级别信息
        Level level = levelMapper.selectById(employee.getLevelId());
        // 构造返回数据
        EmployeeDetailDTO employeeDetailDTO = new EmployeeDetailDTO();
        LevelDTO levelDTO = new LevelDTO();
        BeanUtils.copyProperties(employee, employeeDetailDTO);
        BeanUtils.copyProperties(level, levelDTO);
        employeeDetailDTO.setLevelDTO(levelDTO);
        return ResultDTO.success("data", employeeDetailDTO);
    }
}
