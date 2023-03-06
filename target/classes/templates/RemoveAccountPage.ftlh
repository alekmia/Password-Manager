<#-- @ftlvariable name="account" type="alekmia.work.domain.Account" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="form">
        <div class="header">Remove An Account</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="removeAccount"/>

                <div class="field">
                    <div class="name">
                        <label for="site">Site</label>
                    </div>
                    <div class="value">
                        <input autofocus id="site" name="site" value="${account.site!}"/>
                    </div>
<#--                    <@c.error "site"/>-->
                </div>
                <div class="button-field">
                    <input type="submit" value="Remove">
                </div>
            </form>
        </div>
    </div>
</@c.page>
