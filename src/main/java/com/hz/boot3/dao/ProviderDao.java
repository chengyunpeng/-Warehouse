package com.hz.boot3.dao;
import com.hz.boot3.pojo.Provider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * 供应商dao接口
 */
@Repository
public interface ProviderDao {
    /**
     * 根据ID  删除供应商
     * @param id
     */
    public int deleteProviderById(Integer id);
    /**
     * 修改供应商信息
     * @param provider
     */
    public int updateProvider(Provider provider);
    /**
     * 新增供应商信息
     * @param provider
     */
    public int saveProvider(Provider provider);
    /**
     * 多条件组合查询
     * 翻页查询供应商信息
     * @param pyl  偏移量
     * @param page_size 每页显示条数
     */
    public List<Provider> findProviderList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("proName") String proName,
            @Param("proDesc") String proDesc
    );
    /**
     * 获得总条数
     */
    public Integer findProviderListCount(
            @Param("proName") String proName,
            @Param("proDesc") String proDesc
    );
    /**
     * 根据ID  获得供应商对象
     * @param id
     */
    public Provider findProviderById(Integer id);
}
