package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.base.result.ResultCodeEnum;
import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Level;
import cn.liuliang.quickdinesysstore.entity.dto.LevelDTO;
import cn.liuliang.quickdinesysstore.entity.dto.LevelIdAndNameDTO;
import cn.liuliang.quickdinesysstore.entity.vo.LevelVO;
import cn.liuliang.quickdinesysstore.exception.QuickException;
import cn.liuliang.quickdinesysstore.mapper.LevelMapper;
import cn.liuliang.quickdinesysstore.service.LevelService;
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
public class LevelServiceImpl extends ServiceImpl<LevelMapper, Level> implements LevelService {

    @Autowired
    private LevelMapper levelMapper;

    @Override
    public ResultDTO addOrUpdate(LevelVO levelVO) {
        // 判断必要参数是否为空
        if (StringUtils.isEmpty(levelVO.getLevelName()) || StringUtils.isEmpty(levelVO.getCompensation())) {
            throw new QuickException(ResultCodeEnum.PAEAMETER_IS_EMPTY);
        }
        // 构造数据
        Level level = new Level();
        BeanUtils.copyProperties(levelVO, level);
        // 判断是修改还是添加
        if (null == levelVO.getId()) {
            // 添加
            //执行添加
            ResultDTO.success("data", levelMapper.insert(level));
        }
        // 修改
        return ResultDTO.success("data", levelMapper.updateById(level));
    }

    @Override
    public ResultDTO selectAll(Integer pageNum, Integer pageSize) {
        // 构造分页对象
        Page<Level> levelPage = new Page<>(pageNum, pageSize);
        // 执行查询
        IPage<Level> levelPageModel = levelMapper.selectPage(levelPage, null);
        List<Level> levelList = levelPageModel.getRecords();
        // 构造传输数据对象
        List<LevelDTO> levelDTOList = new ArrayList<>(levelList.size());
        levelList.forEach(level -> {
            LevelDTO levelDTO = new LevelDTO();
            BeanUtils.copyProperties(level, levelDTO);
            levelDTOList.add(levelDTO);
        });
        // 返回数据
        return ResultDTO.success().data("total", levelPageModel.getTotal()).data("rows", levelDTOList);
    }

    @Override
    public ResultDTO getAllLevelIdAndName() {
        // 构造查询对象 LevelIdAndNameDTO
        QueryWrapper<Level> levelQueryWrapper = new QueryWrapper<>();
        levelQueryWrapper.select("id", "level_name");
        // 执行查询
        List<Level> levelList = levelMapper.selectList(levelQueryWrapper);
        // 构造返回结果
        List<LevelIdAndNameDTO> levelIdAndNameDTOList = new ArrayList<>(levelList.size());
        levelList.forEach(level -> {
            LevelIdAndNameDTO levelIdAndNameDTO = new LevelIdAndNameDTO();
            BeanUtils.copyProperties(level, levelIdAndNameDTO);
            levelIdAndNameDTOList.add(levelIdAndNameDTO);
        });
        // 返回数据
        return ResultDTO.success("data", levelIdAndNameDTOList);
    }


}
