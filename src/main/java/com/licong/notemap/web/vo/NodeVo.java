package com.licong.notemap.web.vo;

import com.licong.notemap.domain.Note;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * {category:2, name: '龙-韦恩',value : 1}
 * Created by lctm2005 on 2017/4/9.
 */
@Data
public class NodeVo {

    private static final String HREF_PREFIX = "https://app.yinxiang.com/shard/s31/nl/5910137/";
    private String name;
    private Integer category;
    private String href;
    private Integer value;
    private List<Integer> symbolSize;

    public static NodeVo convert(Note note) {
        NodeVo nodeVo = new NodeVo();
        nodeVo.setName(note.getName());
        nodeVo.setCategory(0);
        // https://[service]/shard/[shardId]/nl/[userId]/[noteGuid]
        List<Integer> symbolSize = new ArrayList<>();
        symbolSize.add(note.getName().length() * 8);
        symbolSize.add(10);
        nodeVo.setSymbolSize(symbolSize);
        nodeVo.setHref(HREF_PREFIX + note.getUuid());
        nodeVo.setValue(note.getName().length() * 2);
        return nodeVo;
    }
}