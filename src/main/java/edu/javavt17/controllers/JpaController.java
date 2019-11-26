package edu.javavt17.controllers;

import edu.javavt17.model.CarBrand;
import edu.javavt17.model.CarModel;
import edu.javavt17.service.CarBrandService;
import edu.javavt17.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class JpaController {
    private static final String INSTRUMENT = "jpa";
    private static final String TITLE = "JPA";
    @Autowired
    @Qualifier("carBrandJpaService")
    private CarBrandService carBrandService;
    @Autowired
    @Qualifier("carModelJpaService")
    private CarModelService carModelService;
    @RequestMapping(value = "/"+INSTRUMENT+"", method = RequestMethod.GET)
    public String printJdbc(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("instrument", INSTRUMENT);
        List<CarBrand> listCarBrand = carBrandService.list();
        List<CarModel> listCarModel = carModelService.list();
        model.addAttribute("listCarModel",listCarModel);
        model.addAttribute("listCarBrand",listCarBrand);
        return "content";
    }
    //CRUD operations with CarBrand entity
    @RequestMapping(value = "/"+INSTRUMENT+"/newBrand", method = RequestMethod.GET)
    public String addBrand(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add new");
        CarBrand carBrand = new CarBrand();
        model.addAttribute("carBrand", carBrand);
        return "brandForm";
    }
    @RequestMapping(value = { "/"+INSTRUMENT+"/newBrand" }, method = RequestMethod.POST)
    public String saveBrand(CarBrand carBrand) {
        carBrandService.saveOrUpdate(carBrand);
        return "redirect:/"+INSTRUMENT;
    }
    @RequestMapping(value = { "/"+INSTRUMENT+"/delete-brand/{idBrand}" }, method = RequestMethod.GET)
    public String deleteBrand(@PathVariable int idBrand) {
        carBrandService.delete(idBrand);
        return "redirect:/"+INSTRUMENT;
    }
    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-brand/{idBrand}" }, method = RequestMethod.GET)
    public String editBrand(@PathVariable int idBrand, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");
        CarBrand carBrand = carBrandService.get(idBrand);
        model.addAttribute("carBrand", carBrand);
        model.addAttribute("edit", true);
        return "brandForm";
    }
    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-brand/{idBrand}" }, method = RequestMethod.POST)
    public String updateBrand(CarBrand carBrand) {
        carBrandService.saveOrUpdate(carBrand);
        return "redirect:/"+INSTRUMENT;
    }
    //CRUD operations with CarModel entity
    @RequestMapping(value = "/"+INSTRUMENT+"/newModel", method = RequestMethod.GET)
    public String addModel(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add new");
        List<CarBrand> listCarBrand = carBrandService.list();
        System.out.println(listCarBrand);
        CarModel carModel = new CarModel();
        model.addAttribute("listCarBrand", listCarBrand);
        model.addAttribute("carModel", carModel);
        return "modelForm";
    }
    @RequestMapping(value = { "/"+INSTRUMENT+"/newModel" }, method = RequestMethod.POST)
    public String saveModel(CarModel carModel) {
        int idBrand = carModel.getIdBrand();
        carModel.setCarBrand(carBrandService.get(idBrand));
        carModelService.saveOrUpdate(carModel);
        return "redirect:/"+INSTRUMENT;
    }
    @RequestMapping(value = { "/"+INSTRUMENT+"/delete-model/{idModel}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int idModel) {
        carModelService.delete(idModel);
        return "redirect:/"+INSTRUMENT;
    }
    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-model/{idModel}" }, method = RequestMethod.GET)
    public String editModel(@PathVariable int idModel, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");
        CarModel carModel = carModelService.get(idModel);
        List<CarBrand> listCarBrand = carBrandService.list();
        model.addAttribute("carModel", carModel);
        model.addAttribute("listCarBrand", listCarBrand);
        return "modelForm";
    }
    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-model/{idModel}" }, method = RequestMethod.POST)
    public String updateModel(CarModel carModel) {
        int idBrand = carModel.getIdBrand();
        carModel.setCarBrand(carBrandService.get(idBrand));
        carModelService.saveOrUpdate(carModel);
        return "redirect:/"+INSTRUMENT;
    }
    @RequestMapping(value = {"/"+INSTRUMENT+"/pdfReport", "/"+INSTRUMENT+"/xlsxReport.xlsx"}, method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("view") String view) {
        ModelAndView modelAndView = new ModelAndView();
        List<CarBrand> listCarBrand = carBrandService.list();
        List<CarModel> listCarModel = carModelService.list();
        // return a view which will be resolved by a ResourceBundleViewResolver
        modelAndView.addObject("carBrands", listCarBrand);
        modelAndView.addObject("carModels", listCarModel);
        modelAndView.setViewName(view);
        return modelAndView;
    }
}