package com.company.Shop.Dao;

import com.company.Shop.Model.CoWorker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoWorkerDao {
    private static final Map<Integer, CoWorker> coWorkerMap = new HashMap<>();

    static {
        initCoWorker();
    }

    private static void initCoWorker() {
        CoWorker coWorker1 = new CoWorker(1, "H&M", "H&M", "123", LocalDateTime.now());
        CoWorker coWorker2 = new CoWorker(2, "ZARA", "zara", "123", LocalDateTime.now());
        CoWorker coWorker3 = new CoWorker(3, "Nike", "nike", "123", LocalDateTime.now());


        coWorkerMap.put(coWorker1.getId(), coWorker1);
        coWorkerMap.put(coWorker2.getId(), coWorker2);
        coWorkerMap.put(coWorker3.getId(), coWorker3);
    }

//    public static List<CoWorker> getAllCoWorkers() {
//        return new ArrayList<>(coWorkerMap.values());
//    }


    public static CoWorker getCoWorker(Integer id){
        return coWorkerMap.get(id);
    }

    public static CoWorker addCoWorker(CoWorker coWorker){
        return  coWorkerMap.put(coWorker.getId() , coWorker);
    }

    public static CoWorker updateCoWorker(CoWorker coWorker){
        return coWorkerMap.put(coWorker.getId(),coWorker);
    }

    public static void deleteCoWorker(Integer id){
        coWorkerMap.remove(id);
    }
}
