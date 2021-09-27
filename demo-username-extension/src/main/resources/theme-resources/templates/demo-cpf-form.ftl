<#import "template.ftl" as layout>
<@layout.registrationLayout displayInfo=true; section>
    <#if section = "title">
        CPF
    <#elseif section = "header">
        Por favor insira seu CPF
    <#elseif section = "form">
        

        <form id="kc-u2f-login-form" class="${properties.kcFormClass!}" action="${url.loginAction}" method="post">
            <div class="${properties.kcFormGroupClass!}">

                <div>
                <input tabindex="1" id="cpf" class="${properties.kcInputClass!}" name="cpf" autofocus type="text" autocomplete="off"/>
                </div>

                <div id="kc-form-buttons" class="${properties.kcFormButtonsClass!}">
                    <input class="${properties.kcButtonClass!} ${properties.kcButtonPrimaryClass!} ${properties.kcButtonLargeClass!}"
                    type="submit" value="${msg("doSubmit")}"/>
                    <input class="${properties.kcButtonClass!} ${properties.kcButtonPrimaryClass!} ${properties.kcButtonLargeClass!}"
                           type="submit" name="cancel" value="${msg("doCancel")}"/>
                </div>
            </div>

        </form>

        <script src="${url.resourcesPath}/../faceauth-theme/js/inputmask.js"></script>
        <script>
            var selector = document.getElementById("cpf");

            var im = new Inputmask("999.999.999-99");
            im.mask(selector);
        </script>
    </#if>
</@layout.registrationLayout>