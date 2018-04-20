package com.test.sell.Controller;

import java.util.ArrayList;
import java.util.List;
import com.test.sell.VO.ProductInfoVO;
import com.test.sell.VO.ProductVO;
import com.test.sell.VO.ResultVO;
import com.test.sell.dataobject.ProductCategory;
import com.test.sell.dataobject.ProductInfo;
import com.test.sell.service.ProductCategoryService;
import com.test.sell.service.ProductInfoService;
import com.test.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @file_name: BuyerProductController
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/13 16:07
 * @version：
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
//    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2. 查询类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
        for(ProductInfo productInfo : productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        //精简方法（java8，lambda）,下面代码有问题
        //List<Integer> categoryTypeList = new productInfoList.stream().map(e -> e.getCategoryType()).collect(Collector.toList());
        List<ProductCategory> productCategorieList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategorieList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
//                    productInfoVO.setProductId(productInfo.getProductId());
//                    productInfoVO.setProductName(productInfo.getProductName());
//                    productInfoVO.setProductPrice(productInfo.getProductPrice());
//                    productInfoVO.setProductDescription(productInfo.getProductDescription());
//                    productInfoVO.setProductIcon(productInfo.getProductIcon());
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);


//        resultVO.setData(Arrays.asList(productVO));

//        productInfoVO.setProductId("1501");
//        productInfoVO.setProductName("绝地求生");
//        productInfoVO.setProductPrice(new BigDecimal(98));
//        productInfoVO.setProductDescription("今晚吃鸡，大吉大利");
//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        return ResultVOUtil.success(productVOList);
    }
}
