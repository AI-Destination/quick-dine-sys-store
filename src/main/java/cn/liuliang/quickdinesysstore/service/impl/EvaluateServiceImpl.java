package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.Evaluate;
import cn.liuliang.quickdinesysstore.entity.dto.EvaluateDTO;
import cn.liuliang.quickdinesysstore.entity.vo.EvaluateQueryConditionVO;
import cn.liuliang.quickdinesysstore.mapper.EvaluateMapper;
import cn.liuliang.quickdinesysstore.service.EvaluateService;
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
public class EvaluateServiceImpl extends ServiceImpl<EvaluateMapper, Evaluate> implements EvaluateService {

    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public ResultDTO selectAll(EvaluateQueryConditionVO evaluateQueryConditionVO, Integer pageNum, Integer pageSize) {
        // 构造分页
        Page<Evaluate> evaluatePage = new Page<>(pageNum, pageSize);
        // 执行查询
        List<Evaluate> evaluateList = evaluateMapper.selectAll(evaluatePage, evaluateQueryConditionVO);
        // 构造传输数据
        List<EvaluateDTO> evaluateDTOList = new ArrayList<>(evaluateList.size());
        evaluateList.forEach(evaluate -> {
            EvaluateDTO evaluateDTO = new EvaluateDTO();
            BeanUtils.copyProperties(evaluate, evaluateDTO);
            evaluateDTOList.add(evaluateDTO);
        });
        return ResultDTO.success().data("total", evaluatePage.getTotal()).data("rows", evaluateDTOList);
    }
}
