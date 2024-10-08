package com.edj.common.handler;

/**
 * 特殊类型转换器
 *
 * @author A.E.
 * @date 2024/9/20
 */
public interface ConvertHandler<O, T> {
    /**
     * 特殊对象类型转换
     *
     * @param originObject 源对象
     * @param targetObject 目标对象
     */
    void map(O originObject, T targetObject);
}
