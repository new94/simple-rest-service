package ru.nenahov.simplerest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.nenahov.simplerest.data.DataDTO;
import ru.nenahov.simplerest.model.ModelUtil;
import ru.nenahov.simplerest.repository.IRepositoryData;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = ModelUtil.PATH_API)
public class SimpleController {

    private final IRepositoryData repositoryData;

    public SimpleController(IRepositoryData repositoryData) {
        this.repositoryData = repositoryData;
    }

    @GetMapping(value = ModelUtil.PATH_API_SAVE_MESSAGE)
    public ModelAndView getData(@PathVariable String message) {
        DataDTO data = new DataDTO();
        data.setData(message);

        repositoryData.save(data);

        Map<String, String> model = new HashMap<>();
        model.put(ModelUtil.NAME_VARIABLE_DATA_INDEX, data.toString());
        return new ModelAndView(ModelUtil.NAME_INDEX_PAGE_HTML, model);
    }

    @GetMapping(value = ModelUtil.PATH_API_GET_BY_ID)
    public ModelAndView postData(@PathVariable Long id) {
        DataDTO dataFind = repositoryData.findOne(id);

        Map<String, String> model = new HashMap<>();
        String namePageResponse;
        if (dataFind != null) {
            model.put(ModelUtil.NAME_VARIABLE_DATA_INDEX, dataFind.toString());
            namePageResponse = ModelUtil.NAME_INDEX_PAGE_HTML;
        } else {
            model.put(ModelUtil.NAME_VARIABLE_DATA_INDEX, "Not found data by id = " + id);
            namePageResponse = ModelUtil.NAME_NOT_FOUND_PAGE_HTML;
        }

        return new ModelAndView(namePageResponse, model);
    }

}
