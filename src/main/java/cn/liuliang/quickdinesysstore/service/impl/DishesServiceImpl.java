package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.base.result.ResultCodeEnum;
import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Dishes;
import cn.liuliang.quickdinesysstore.entity.DishesType;
import cn.liuliang.quickdinesysstore.entity.dto.DishesDTO;
import cn.liuliang.quickdinesysstore.entity.vo.DishesQueryConditionVO;
import cn.liuliang.quickdinesysstore.entity.vo.DishesVO;
import cn.liuliang.quickdinesysstore.exception.QuickException;
import cn.liuliang.quickdinesysstore.mapper.DishesMapper;
import cn.liuliang.quickdinesysstore.mapper.DishesTypeMapper;
import cn.liuliang.quickdinesysstore.service.DishesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class DishesServiceImpl extends ServiceImpl<DishesMapper, Dishes> implements DishesService {

    @Autowired
    private DishesMapper dishesMapper;

    @Autowired
    private DishesTypeMapper dishesTypeMapper;

    @Override
    public ResultDTO addOrUpdate(DishesVO dishesVO) {
        // 判断条件是否为空
        if (null == dishesVO.getDishesName() || "".equals(dishesVO.getDishesName()) ||
                null == dishesVO.getDishesTypeId() || "".equals(dishesVO.getDishesTypeId().toString()) ||
                null == dishesVO.getImageUrl() || "".equals(dishesVO.getImageUrl()) ||
                null == dishesVO.getPrice() || "".equals(dishesVO.getPrice().toString())) {
            // 为空，抛出自定义异常
            throw new QuickException(ResultCodeEnum.PAEAMETER_IS_EMPTY);
        }
        // 判断是插入还是修改
        if (null == dishesVO.getId()) {
            // 插入
            // 构造插入对象，并赋值
            Dishes dishes = new Dishes();
            BeanUtils.copyProperties(dishesVO, dishes);
            dishesMapper.insert(dishes);
        } else {
            // 修改
            // 根据id查找数据
            QueryWrapper<Dishes> dishesQueryWrapper = new QueryWrapper<>();
            dishesQueryWrapper
                    .select("dishes_name", "dishes_type_id", "brief_introduction", "image_url", "price")
                    .eq("id", dishesVO.getId());
            Dishes dishes = dishesMapper.selectOne(dishesQueryWrapper);
            BeanUtils.copyProperties(dishesVO, dishes);
            dishesMapper.updateById(dishes);
        }
        return ResultDTO.success();
    }

    @Override
    public ResultDTO selectAll(DishesQueryConditionVO dishesQueryConditionVO, Integer pageNum, Integer pageSize) {
        // 构造分页
        Page<Dishes> dishesPage = new Page<>(pageNum, pageSize);
        // 执行条件查询
        List<Dishes> dishesList = dishesMapper.selectAll(dishesPage, dishesQueryConditionVO);
        // 获取相关数据
        long total = dishesPage.getTotal();
        List<DishesDTO> dishesDTOList = selectDishesTypeName(dishesList);
        // 返回结果
        return ResultDTO.success().data("total", total).data("rows", dishesDTOList);
    }

    @Override
    public ResultDTO selectOne(Long id) {
        Dishes dishes = dishesMapper.selectById(id);
        // 构造数据
        DishesDTO dishesDTO = new DishesDTO();
        BeanUtils.copyProperties(dishes, dishesDTO);
        // 定义查询条件
        QueryWrapper<DishesType> dishesTypeQueryWrapper = new QueryWrapper<>();
        // 查询分类名称并赋值
        dishesTypeQueryWrapper.select("type_name").eq("id", dishesDTO.getDishesTypeId());
        dishesDTO.setDishesTypeName(dishesTypeMapper.selectOne(dishesTypeQueryWrapper).getTypeName());
        return ResultDTO.success().data("data", dishesDTO);
    }

    /**
     * 设置传入的菜品列表数据的菜品分类名称
     *
     * @param dishesList 菜品列表，没有菜品分类名称
     * @return
     */
    private List<DishesDTO> selectDishesTypeName(List<Dishes> dishesList) {
        // 定义返回结果列表
        List<DishesDTO> dishesDTOList = new ArrayList<>(dishesList.size());
        // 遍历
        dishesList.forEach(dishes -> {
            // 填充数据
            DishesDTO dishesDTO = new DishesDTO();
            BeanUtils.copyProperties(dishes, dishesDTO);
            // 定义查询条件
            QueryWrapper<DishesType> dishesTypeQueryWrapper = new QueryWrapper<>();
            // 查询分类名称并赋值
            dishesTypeQueryWrapper.select("type_name").eq("id", dishesDTO.getDishesTypeId());
            dishesDTO.setDishesTypeName(dishesTypeMapper.selectOne(dishesTypeQueryWrapper).getTypeName());
            // 将结果放入返回列表中
            dishesDTOList.add(dishesDTO);
        });
        // 返回数据列表
        return dishesDTOList;
    }
}
