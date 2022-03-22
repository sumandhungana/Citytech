package global.citytech.interns.cms.adminwebjsf.foos.controllers;

import global.citytech.interns.cms.adminwebjsf.foos.converters.FooPayloadConverter;
import global.citytech.interns.cms.adminwebjsf.foos.models.Foo;
import global.citytech.interns.cms.adminwebjsf.foos.models.FooDetail;
import global.citytech.interns.cms.adminwebjsf.foos.models.FooDetailDto;
import global.citytech.interns.cms.adminwebjsf.foos.models.FooDto;
import global.citytech.interns.crm.platform.usecases.UseCaseContext;
import global.citytech.interns.crm.services.foos.payloads.*;
import global.citytech.interns.crm.services.foos.payloads.domains.FooDetailInfo;
import global.citytech.interns.crm.services.foos.payloads.domains.FooInfo;
import global.citytech.interns.crm.services.foos.usecases.AddFooUseCase;
import global.citytech.interns.crm.services.foos.usecases.EditFooUseCase;
import global.citytech.interns.crm.services.foos.usecases.GetAllFoosUseCase;
import global.citytech.interns.crm.services.foos.usecases.GetFooUseCase;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class FooController implements Serializable {

    private final String LIST_PAGE = "pretty:foos";

    Foo instance;
    String selectedItem;
    List<Foo> list;
    FooDetail detailInstance;
    FooDetail selectedDetailInstance;

    private GetAllFoosUseCase getAllFoosUseCase;

    private GetFooUseCase getFooUseCase;

    private AddFooUseCase addFooUseCase;

    private EditFooUseCase editFooUseCase;

    public FooController() {
    }

    @Inject
    public FooController(GetAllFoosUseCase getAllFoosUseCase, GetFooUseCase getFooUseCase, AddFooUseCase addFooUseCase, EditFooUseCase editFooUseCase) {
        this.getAllFoosUseCase = getAllFoosUseCase;
        this.getFooUseCase = getFooUseCase;
        this.addFooUseCase = addFooUseCase;
        this.editFooUseCase = editFooUseCase;
    }

    public Foo getInstance() {
        return instance;
    }

    public void setInstance(Foo instance) {
        this.instance = instance;
    }

    public FooDetail getDetailInstance() {
        return detailInstance;
    }

    public void setDetailInstance(FooDetail detailInstance) {
        this.detailInstance = detailInstance;
    }

    public void loadList() {
        GetAllFoosResponse response = this.getAllFoosUseCase.execute(UseCaseContext.emptyContext(), new GetAllFoosRequest());
        if(response == null){
            return;
        }

        FooPayloadConverter payloadConverter = new FooPayloadConverter();
        this.list = payloadConverter.toResponseList(response.list());
    }

    public List<Foo> getList() {
        return list;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String itemValue){
        this.selectedItem = itemValue;
    }

    public void loadAddForm(){
        if(this.instance == null) {
            this.     instance = new FooDto();
        }
    }

    public void loadSelectedItem() {
        if(this.instance != null){
            return;
        }
        GetFooRequest request = new GetFooRequest();
        request.setId(this.selectedItem);
        GetFooResponse response = this.getFooUseCase.execute(UseCaseContext.emptyContext(), request);

        FooInfo info = response.getFooInfo();
        FooPayloadConverter payloadConverter = new FooPayloadConverter();
        this.instance  = payloadConverter.toResponse(info);
    }

    public String onSave(){
        if(this.instance.getId() == null){
            this.add();
        }else{
            this.edit();
        }
        return LIST_PAGE;
    }

    private void add(){
        AddFooRequest addFooRequest = new AddFooRequest();
        addFooRequest.setName(this.instance.getName());
        addFooRequest.setDetails(this.instance.getDetails().stream().map(i-> this.toFooDetailInfo(i)).collect(Collectors.toList()));
        this.addFooUseCase.execute(UseCaseContext.emptyContext(), addFooRequest);
    }

    private FooDetailInfo toFooDetailInfo(FooDetail detail){
        FooDetailInfo detailInfo = new FooDetailInfo();
        detailInfo.setAlias(detail.getAlias());
        return detailInfo;
    }

    private void edit(){
        System.out.println("INSTANCE ID = "+ this.instance.getId());
        System.out.println("INSTANCE NAME = "+ this.instance.getName());
        EditFooRequest editFooRequest = new EditFooRequest();
        editFooRequest.setId(this.instance.getId());
        editFooRequest.setName(this.instance.getName());
        editFooRequest.setDetails(this.instance.getDetails().stream().map(i-> this.toFooDetailInfo(i)).collect(Collectors.toList()));
        this.editFooUseCase.execute(UseCaseContext.emptyContext(), editFooRequest);
    }

    public void onLoadAddDetail(){
        System.out.println("Loading Add Detail");
        this.detailInstance = new FooDetailDto();
    }

    public void onAddDetail(){
        System.out.println("Adding "+this.detailInstance.getAlias());
        this.instance.addDetail(this.detailInstance);
        System.out.println("Detail size =" + this.instance.getDetails().size());
    }

    public FooDetail getSelectedDetailInstance() {
        return selectedDetailInstance;
    }

    public void setSelectedDetailInstance(FooDetail selectedDetailInstance) {
        this.selectedDetailInstance = selectedDetailInstance;
    }

}


