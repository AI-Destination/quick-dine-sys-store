package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.base.result.ResultCodeEnum;
import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.DiningTable;
import cn.liuliang.quickdinesysstore.entity.dto.DiningTableDTO;
import cn.liuliang.quickdinesysstore.entity.vo.DiningTableVO;
import cn.liuliang.quickdinesysstore.exception.QuickException;
import cn.liuliang.quickdinesysstore.mapper.DiningTableMapper;
import cn.liuliang.quickdinesysstore.service.DiningTableService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Service
public class DiningTableServiceImpl extends ServiceImpl<DiningTableMapper, DiningTable> implements DiningTableService {

    @Autowired
    private DiningTableMapper diningTableMapper;


    @Override
    public ResultDTO addOrUpdate(DiningTableVO diningTableVO) {
        // 判断参数是否为空
        if (StringUtils.isEmpty(diningTableVO.getDiningTableNumber())
                || StringUtils.isEmpty(diningTableVO.getDiningTableName())) {
            throw new QuickException(ResultCodeEnum.PAEAMETER_IS_EMPTY);
        }
        // 判断是添加还是修改
        if (null == diningTableVO.getId()) {
            // 插入
            // 构造数据
            DiningTable diningTable = new DiningTable();
            BeanUtils.copyProperties(diningTableVO, diningTable);
            // 插入
            diningTableMapper.insert(diningTable);
        } else {
            // 修改
            // 根据id查询需要的数据
            QueryWrapper<DiningTable> diningTableQueryWrapper = new QueryWrapper<>();
            diningTableQueryWrapper
                    .select("dining_table_number", "dining_table_name")
                    .eq("id", diningTableVO.getId());
            DiningTable diningTable = diningTableMapper.selectOne(diningTableQueryWrapper);
            BeanUtils.copyProperties(diningTableVO, diningTable);
            diningTableMapper.updateById(diningTable);
        }
        return ResultDTO.success();
    }

    @Override
    public ResultDTO selectAll(Integer pageNum, Integer pageSize) {
        // 构造分页
        Page<DiningTable> diningTablePage = new Page<>(pageNum, pageSize);
        // 分页查询
        IPage<DiningTable> diningTablePageModel = diningTableMapper.selectPage(diningTablePage, null);
        // 构造返回数据
        List<DiningTable> diningTableList = diningTablePageModel.getRecords();
        long total = diningTablePageModel.getTotal();
        return ResultDTO.success().data("total", total).data("rows", diningTableList);
    }

    @Override
    public ResultDTO selectOne(Long id) {
        // 执行查询
        DiningTable diningTable = diningTableMapper.selectById(id);
        // 构造返回数据
        DiningTableDTO diningTableDTO = new DiningTableDTO();
        BeanUtils.copyProperties(diningTable, diningTableDTO);
        return ResultDTO.success().data("data", diningTableDTO);
    }
}
