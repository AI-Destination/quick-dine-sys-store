package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.base.result.ResultCodeEnum;
import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.DishesType;
import cn.liuliang.quickdinesysstore.entity.dto.DishesTypeDTO;
import cn.liuliang.quickdinesysstore.entity.vo.DishesTypeVO;
import cn.liuliang.quickdinesysstore.exception.QuickException;
import cn.liuliang.quickdinesysstore.mapper.DishesTypeMapper;
import cn.liuliang.quickdinesysstore.service.DishesTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
public class DishesTypeServiceImpl extends ServiceImpl<DishesTypeMapper, DishesType> implements DishesTypeService {

    @Autowired
    private DishesTypeMapper dishesTypeMapper;

    @Override
    public ResultDTO selectPage(String selectValue, Integer pageNum, Integer pageSize) {
        // 设置分页参数
        Page<DishesType> dishesTypePage = new Page<>(pageNum, pageSize);
        // 定义创建条件对象
        QueryWrapper<DishesType> queryWrapper = null;
        //判断是否有查询值
        if (!StringUtils.isEmpty(selectValue)) {
            // 创建查询对象
            queryWrapper = new QueryWrapper<>();
            // 定义查询条件 like全查
            queryWrapper.like("type_name", selectValue);
        }
        // 执行查询
        IPage<DishesType> dishesTypePageModel = dishesTypeMapper.selectPage(dishesTypePage, queryWrapper);
        // 获取总条数
        Integer total = Math.toIntExact(dishesTypePageModel.getTotal());
        // 数据转换及获取数据
        List<DishesTypeDTO> dishesTypeDTOList = new ArrayList<>();
        List<DishesType> records = dishesTypePageModel.getRecords();
        records.forEach(DishesType -> {
            DishesTypeDTO dishesTypeDTO = new DishesTypeDTO();
            BeanUtils.copyProperties(DishesType, dishesTypeDTO);
            dishesTypeDTOList.add(dishesTypeDTO);
        });
        // 返回数据
        return ResultDTO.success().data("total", total).data("rows", dishesTypeDTOList);
    }

    @Override
    public ResultDTO addOrUpdateDishesType(DishesTypeVO dishesTypeVO) {
        // 判断条件是否为空
        if (StringUtils.isEmpty(dishesTypeVO.getTypeName())) {
            // 为空，抛出自定义异常
            throw new QuickException(ResultCodeEnum.PAEAMETER_IS_EMPTY);
        }
        // 构造插入对象
        DishesType dishesType = new DishesType();
        // 设置数据
        BeanUtils.copyProperties(dishesTypeVO, dishesType);
        if (null == dishesTypeVO.getId()) {
            // 插入
            return ResultDTO.success("data", dishesTypeMapper.insert(dishesType));
        }
        return ResultDTO.success("data", dishesTypeMapper.updateById(dishesType));
    }

    @Override
    public ResultDTO delete(Long id) {
        dishesTypeMapper.deleteById(id);
        return ResultDTO.success();
    }

    @Override
    public ResultDTO selectOne(Long id) {
        DishesType dishesType = dishesTypeMapper.selectById(id);
        if (null == dishesType){
            return ResultDTO.success("data", null);
        }
        DishesTypeDTO dishesTypeDTO = new DishesTypeDTO();
        BeanUtils.copyProperties(dishesType, dishesTypeDTO);
        return ResultDTO.success("data", dishesTypeDTO);
    }
}
