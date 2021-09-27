<#import "template.ftl" as layout>
<@layout.registrationLayout displayInfo=false; section>
  



    <#if section = "title">
        Senha
    <#elseif section = "header">
        Por favor insira sua senha
    <#elseif section = "form">
        
        <link href="${url.resourcesPath}/../faceauth-theme/js/toastr.css" rel="stylesheet"/>
        <h1>Por favor insira sua senha</h1>

        <form id="kc-u2f-login-form" class="${properties.kcFormClass!}" action="${url.loginAction}" method="post">
            <div class="${properties.kcFormGroupClass!}">

                <div>
                <input tabindex="1" id="senha" class="${properties.kcInputClass!}" name="senha" autofocus type="password" autocomplete="off"/>
                </div>

                <div id="kc-form-buttons" class="${properties.kcFormButtonsClass!}">
                    <input class="${properties.kcButtonClass!} ${properties.kcButtonPrimaryClass!} ${properties.kcButtonLargeClass!}"
                    type="submit" value="${msg("doSubmit")}"/>
                    <input class="${properties.kcButtonClass!} ${properties.kcButtonPrimaryClass!} ${properties.kcButtonLargeClass!}"
                           type="submit" name="cancel" value="${msg("doCancel")}"/>
                </div>
            </div>

        </form>

<script
  src="https://code.jquery.com/jquery-1.12.4.js"
  integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
  crossorigin="anonymous"></script>
        <script src="${url.resourcesPath}/../faceauth-theme/js/toastr.js"></script>
        <script src="${url.resourcesPath}/../faceauth-theme/js/inputmask.js"></script>
        <script>
        toastr.options = {
          "closeButton": false,
          "debug": false,
          "newestOnTop": false,
          "progressBar": true,
          "positionClass": "toast-top-right",
          "preventDuplicates": false,
          "showDuration": "5000",
          "hideDuration": "1000",
          "timeOut": "10000",
          "extendedTimeOut": "1000",
          "showEasing": "swing",
          "hideEasing": "linear",
          "showMethod": "fadeIn",
          "hideMethod": "fadeOut"
        };

        setTimeout(function(){ toastr.warning('Olá, tudo bem?'); }, 5000);
        setTimeout(function(){ toastr.warning('Você ainda não digitou sua senha....'); }, 10000);

        
        </script>
    </#if>
</@layout.registrationLayout>