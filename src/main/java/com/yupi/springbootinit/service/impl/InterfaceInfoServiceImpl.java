package com.yupi.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yupi.springbootinit.mapper.InterfaceInfoMapper;
import com.yupi.springbootinit.model.entity.InterfaceInfo;
import com.yupi.springbootinit.service.InterfaceInfoService;
import org.springframework.stereotype.Service;

/**
* @author CAODONG
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2024-04-01 17:31:39
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

}




