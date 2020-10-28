package cn.liuliang.quickdinesysstore.service.impl;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.CookingSkillImages;
import cn.liuliang.quickdinesysstore.entity.dto.CookingSkillImagesDTO;
import cn.liuliang.quickdinesysstore.mapper.CookingSkillImagesMapper;
import cn.liuliang.quickdinesysstore.service.CookingSkillImagesService;
import cn.liuliang.quickdinesysstore.service.OSSFileService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
public class CookingSkillImagesServiceImpl extends ServiceImpl<CookingSkillImagesMapper, CookingSkillImages> implements CookingSkillImagesService {

    @Autowired
    private CookingSkillImagesMapper cookingSkillImagesMapper;

    @Autowired
    private OSSFileService ossFileService;


    @Override
    public ResultDTO selectPage(Integer pageNum, Integer pageSize) {
        // 定义分页
        Page<CookingSkillImages> cookingSkillImagesPage = new Page<>(pageNum, pageSize);
        // 开始分页查询
        IPage<CookingSkillImages> cookingSkillImagesPageModel = cookingSkillImagesMapper.selectPage(cookingSkillImagesPage, null);
        // 获取分页数据和总条数
        List<CookingSkillImages> records = cookingSkillImagesPageModel.getRecords();
        long total = cookingSkillImagesPageModel.getTotal();
        // 转化数据传输对象
        List<CookingSkillImagesDTO> cookingSkillImagesDTOList = new ArrayList<>(records.size());
        records.forEach(CookingSkillImages -> {
            CookingSkillImagesDTO cookingSkillImagesDTO = new CookingSkillImagesDTO();
            BeanUtils.copyProperties(CookingSkillImages, cookingSkillImagesDTO);
            cookingSkillImagesDTOList.add(cookingSkillImagesDTO);
        });
        // 返回结果
        return ResultDTO.success().data("tital", total).data("rows", cookingSkillImagesDTOList);
    }

    @Override
    public ResultDTO addCookingSkillImages(String[] imageUrls) {
        // 遍历url数组，依次插入数据库中
        Arrays.asList(imageUrls).forEach(imageUrl -> {
            CookingSkillImages cookingSkillImages = new CookingSkillImages();
            cookingSkillImages.setImageUrl(imageUrl);
            cookingSkillImagesMapper.insert(cookingSkillImages);
        });
        return ResultDTO.success();
    }

    @Override
    public ResultDTO delete(Long id, String url) {
        // 先删除数据库中的图片
        cookingSkillImagesMapper.deleteById(id);
        // 再删除OSS服务器上的图片
        ossFileService.removeFile(url);
        return ResultDTO.success();
    }
}
