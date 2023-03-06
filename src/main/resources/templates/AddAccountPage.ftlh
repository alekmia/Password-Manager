<#-- @ftlvariable name="account" type="alekmia.work.domain.Account" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="form">
        <div class="header">Add Account</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="addAccount"/>

                <div class="field">
                    <div class="name">
                        <label for="site">Site</label>
                    </div>
                    <div class="value">
                        <input autofocus id="site" name="site" value="${account.site!}"/>
                    </div>
                    <@c.error "account.site"/>
                </div>

                <div class="field">
                    <div class="name">
                        <label for="login">Login</label>
                    </div>
                    <div class="value">
                        <input id="login" name="login" value="${account.login!}"/>
                    </div>
                    <@c.error "account.login"/>
                </div>

                <div class="field">
                    <div class="name">
                        <label for="password">Password</label>
                    </div>
                    <div class="value">
                        <input id="password" name="password" value="${account.password!}"/>
                    </div>
                    <@c.error "account.password"/>
                </div>

                <div class="password_suggestor" style="margin-bottom: 15px">
                    Suggested password: ${suggested_password}<br>
                </div>
                <div class="button-field">
                    <input type="submit" value="Make a new account on said site">
                </div>
            </form>
        </div>
    </div>
</@c.page>
