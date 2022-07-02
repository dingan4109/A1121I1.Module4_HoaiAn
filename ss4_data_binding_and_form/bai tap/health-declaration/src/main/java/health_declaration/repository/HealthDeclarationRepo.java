package health_declaration.repository;

import health_declaration.model.HealthDeclaration;

import java.util.List;

public interface HealthDeclarationRepo {
    void save(HealthDeclaration healthDeclaration);
    HealthDeclaration getHealthDeclarationByIdCard(String idCard);
}
