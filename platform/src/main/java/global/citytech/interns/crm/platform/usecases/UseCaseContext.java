package global.citytech.interns.crm.platform.usecases;

public interface UseCaseContext {
    static UseCaseContext emptyContext(){
        return new UseCaseContext(){
        };
    }
}
