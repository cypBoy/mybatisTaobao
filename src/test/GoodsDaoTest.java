package test;

import com.icss.dao.GoodsDao;
import com.icss.entity.Goods;
import com.icss.util.SQLSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GoodsDaoTest {

    @Test
    public void listByPage() {
        SqlSession sqlSession = SQLSessionUtil.getSqlSession();
        GoodsDao dao = sqlSession.getMapper(GoodsDao.class);
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("index", 3);
        map.put("pageSize",2);
        List<Goods> list = dao.listByPage(map);
        if(list != null){
            for(Goods g : list){
                System.out.println(g);
            }
        }
    }

    @Test
    public void getCount() {
    }
}