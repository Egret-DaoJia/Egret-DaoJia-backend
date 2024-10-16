package com.edj.foundations.controller.operation;

import com.edj.foundations.domain.dto.RegionAddDTO;
import com.edj.foundations.domain.dto.RegionUpdateDTO;
import com.edj.foundations.service.EdjRegionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 运营端 - 区域相关接口
 *
 * @author A.E.
 * @date 2024/10/16
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("operation/region")
@Tag(name = "运营端 - 区域相关接口")
public class OperationRegionController {

    private final EdjRegionService regionService;

    /**
     * 新增区域
     */
    @PostMapping
    @Operation(summary = "新增区域")
    @PreAuthorize("hasAuthority('foundations:region:add')")
    public void add(@RequestBody @Validated RegionAddDTO regionAddDTO) {
        regionService.add(regionAddDTO);
    }

    /**
     * 修改区域
     */
    @PutMapping
    @Operation(summary = "修改区域")
    @PreAuthorize("hasAuthority('foundations:region:update')")
    public void update(@RequestBody @Validated RegionUpdateDTO regionUpdateDTO) {
        regionService.update(regionUpdateDTO);
    }
}
