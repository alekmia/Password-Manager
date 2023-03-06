<#import "commons.ftlh" as c>

<@c.page>
    <div class="title" >
        Your accounts:
    </div>
<#--        <@c.post country=country/>-->
    <div class="accountsList">
        <ul>
            <#list user.accounts as account>
                <li>${account.getSite()}: <br>
                    login: ${account.getLogin()} <br>
                    password: ${account.getPassword()}</li>
            </#list>
        </ul>
    </div>
</@c.page>
