package pages;


import core.azure.model.attachment.Attachment;
import core.driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import support.selenium.Action;
import support.selenium.Verifications;

import java.util.HashMap;

@Log4j2
public class LoginPage extends DriverManager implements CommonTestingType {

    private By txtUsuario = By.name("email");
    private By txtSenha = By.name("senha");
    private By btnEntrar = By.xpath("//button");
    private By abaLogin = By.xpath("//a[contains(text(),'Login')]");
    private By lblErrorMsg = By.xpath("//*[contains(text(),'Problemas com o login do usuário')]");

    @Override
    public boolean isPresent() {
        return  Verifications.verifyTextsElementClickable(abaLogin,"Login")
                && Verifications.verifyElementIsClickable(txtUsuario);
    }

    public void acessaAplicacao(){
        getDriver().get(configuration.url());
        attachments.add(new Attachment("png",null));
        log.info("Acesso a aplicacao efetuado com sucesso");
    }

    public void executaLogin(HashMap data){
        Action.setText(txtUsuario,data.get("usuario"));
        getDriver().findElement(txtSenha).sendKeys((CharSequence) data.get("senha"));
        attachments.add(new Attachment("png",null));
        Action.clickOnElement(btnEntrar);
        log.info("Login na aplicacao efetuado com sucesso");
    }

    public boolean isErrorMsg(){
        attachments.add(new Attachment("png",null));
        return Verifications.verifyElementIsClickable(lblErrorMsg);
    }

}
