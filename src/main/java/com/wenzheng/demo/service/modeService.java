package com.wenzheng.demo.service;


import com.wenzheng.demo.dal.modeRepository;
import com.wenzheng.demo.entity.QAEntityItem;
import com.wenzheng.demo.entity.Rship;
import com.wenzheng.demo.entity.mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class modeService {

    @Autowired
    modeRepository modeRepository;

    public HashMap<String, Object> getModeGraph(String name) {
        HashMap<String, Object> result = new HashMap<String, Object>();

        if (name.equals("挂号")) {
            name = "缴费";
        } else if (name.equals("结束")) {
            name = "缴药费";
        }
        System.out.println(name);
        List<mode> modesByName = modeRepository.getModesByName(name);
        int index = 1;
        try {
            result = gethashmap(modesByName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public HashMap<String, Object> gethashmap(List<mode> modesByName) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        List<HashMap<String, Object>> ents = new ArrayList<HashMap<String, Object>>();
        List<HashMap<String, Object>> ships = new ArrayList<HashMap<String, Object>>();
        for (mode mode : modesByName) {
            HashMap<String, Object> rss = new HashMap<String, Object>();
            rss.put("r", mode.getR());
            rss.put("fx", mode.getFx());
            rss.put("fy", mode.getFy());
            rss.put("color", mode.getColor());
            rss.put("name", mode.getName());
            rss.put("uuid", String.valueOf(mode.getId()));
            for (Rship modenext : mode.getRMode()) {
                HashMap<String, Object> rships = new HashMap<String, Object>();
                rships.put("sourceid", String.valueOf(modenext.getStart().getId()));
                rships.put("targetid", String.valueOf(modenext.getEnd().getId()));
                rships.put("name", "RE");
                rships.put("uuid", String.valueOf(modenext.getId()));
                ships.add(rships);
            }
            ents.add(rss);
        }
        result.put("node", ents);
        result.put("relationship", ships);
        return result;

    }

    public void Save(mode mode) {
        modeRepository.save(mode);
    }

    public HashMap<String, Object> createnode(QAEntityItem entity) {
        HashMap<String, Object> result = new HashMap<>();
        mode mode = modeRepository.findById(entity.getUuid());
        mode.setName(entity.getName());
        mode.setColor(entity.getColor());
        modeRepository.save(mode);
        mode = modeRepository.findByName(entity.getName());
        result.put("r", mode.getR());
        result.put("color", mode.getColor());
        result.put("fx", mode.getFx());
        result.put("name", mode.getName());
        result.put("fy", mode.getFy());
        result.put("uuid", String.valueOf(mode.getId()));

        return result;
    }

    public HashMap<String, Object> getall() {
        HashMap<String, Object> result = new HashMap<String, Object>();

        List<mode> modesByName = modeRepository.findAll();
        int index = 1;
        try {
            result = gethashmap(modesByName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public mode findbyid(long id) {
        return modeRepository.findById(id);
    }

    public HashMap<String,Object> batchcreatechildnode( long sourceid, String[] targetnames) {

        HashMap<String, Object> rss = new HashMap<String, Object>();
        mode source = modeRepository.findById(sourceid);
        for (String name:targetnames
             ) {
            mode target = new mode();
            target.setName(name);
            Rship rship = new Rship();
            rship.setStart(source);
            rship.setEnd(target);
            source.getRMode().add(rship);
            modeRepository.save(source);
        }
        rss = gethashmap(modeRepository.getById(sourceid));
        return rss;
    }

    public List<HashMap<String, Object>> deletenode(long id) {
        List<HashMap<String, Object>> result = new ArrayList<>();
        HashMap<String, Object> hashMap = new HashMap<>();
        mode byId = modeRepository.findById(id);
        hashMap.put("r", byId.getR());
        hashMap.put("name", byId.getName());
        hashMap.put("uuid", String.valueOf(byId.getId()));
        hashMap.put("fx", byId.getFx());
        hashMap.put("fy", byId.getFy());
        hashMap.put("color", byId.getColor());
        result.add(hashMap);
        modeRepository.deleteById(id);
        return result;
    }

}
