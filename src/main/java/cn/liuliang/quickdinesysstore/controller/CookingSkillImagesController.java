package cn.liuliang.quickdinesysstore.controller;


import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.entity.dto.CookingSkillImagesDTO;
import cn.liuliang.quickdinesysstore.entity.vo.CookingSkillImagesVO;
import cn.liuliang.quickdinesysstore.service.CookingSkillImagesService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器：图片秀管理控制器
 * </p>
 *
 * @author j3_liuliang
 * @since 2020-10-24
 */
@Api(value = "厨艺秀图片管理", tags = "厨艺秀图片管理")
@CrossOrigin
@RestController
@RequestMapping("/cooking-skill-images")
public class CookingSkillImagesController {

    @Autowired
    private CookingSkillImagesService cookingSkillImagesService;

    @ApiOperation(value = "分页查看所有厨艺秀图片", notes = "分页查看所有厨艺秀图片")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功！", response = CookingSkillImagesDTO.class)})
    @GetMapping("/select-all")
    public ResultDTO selectAllCookingSkillImages(
            @ApiParam("当前页码") @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @ApiParam("每页显示条数") @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return cookingSkillImagesService.selectPage(pageNum, pageSize);
    }


    @ApiOperation(value = "添加厨艺秀照片", notes = "添加厨艺秀照片")
    @PostMapping("/add")
    public ResultDTO addCookingSkillImages(
            @ApiParam(value = "厨艺秀对象vo", required = true)
            @RequestBody CookingSkillImagesVO cookingSkillImagesVO) {
        return cookingSkillImagesService.addCookingSkillImages(cookingSkillImagesVO.getImageUrl());
    }

    @ApiOperation(value = "删除厨艺秀照片", notes = "删除厨艺秀照片")
    @GetMapping("/delete")
    public ResultDTO delete(
            @ApiParam("图片id") @RequestParam(value = "id", required = true) Long id,
            @ApiParam("图片url") @RequestParam(value = "url", required = true) String url) {
        return cookingSkillImagesService.delete(id, url);
    }


}


