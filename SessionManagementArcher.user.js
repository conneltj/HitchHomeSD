// ==UserScript==
// @name         ArcherFixesV1
// @namespace    http://mgroupnet.com/userscripts/Connell/
// @version      0.2 - 6/13/18
// @description  Session management and autocorrect fixes.
// @author       Tom Connell
// @match        https://archer.mgroupnet.com/*
// @grant        none
// ==/UserScript==

/*Adds spellchecking by default to the divs (no literally, they use divs as inputs....not inputs/textareas.....i digress*/
$("[class^=RichTextEditor]").each(function() { $(this).attr("spellcheck", "true")});


/*Session management static variables*/
var sessionUpdate = "/api/internal/sessiontimeout/UpdateSession";
var sessionTimeoutGet = "/api/internal/sessiontimeout/GetSessionExpirationTime";
var extendCounter = 0;
var sessionTimeoutMinutes = 0;
var minutesToCheck = 1;
var minutesToRenew = 180;
var errorCount = 0;
var abortInterval = false;


/*Javascript set to repeat every X minutes as defined by the variable above* or until error....will fix in future patch*/

function postRenewSession()
{
    var request = Ext.Ajax.request(
        {
            url: sessionUpdate,
            method: "POST",
            success: function(a, g) {
                var e = Ext.decode(a.responseText);
                if (e.RequestedObject === true) {
                    minutesToRenew -= 15;
                }
            }
        }
    );
}

function getMinutesLeft()
{
    Ext.Ajax.request(
        {
            url: sessionTimeoutGet,
            method: "GET",
            success: function(a, e) {
                var g = Ext.decode(a.responseText).RequestedObject;
                sessionTimeoutMinutes = g.SessionTimeoutMinutes;
                resolveGetResponse();
            }
        });
}

function resolveGetResponse()
{
    if(sessionTimeoutMinutes < 15)
    {
        if(minutesToRenew < 0)
        {
            postRenewSession();
        }
        else
        {
            saveProgressIfAvailable();
        }
    }
}

function saveProgressIfAvailable()
{
    var saveButton = $("#master_btnApply");
            if($(saveButton).hasClass("aspNetDisabled"))
            {
                $(saveButton).click();
                alert("You have " + sessionTimeoutMinutes + " until you must manually renew. Your work has automatically been saved");
            }
            extendCounter = 0;
            clearInterval(sm);
}

function sessionManagement()
{
    try
    {
        getMinutesLeft();
    }
    catch (err)
    {
        //Something has gone horribly wrong, so wea are going to wait 10 seconds and try to renew again.
        if(!abortInterval)
        {
            if(errorCount > 4)
            {
                abortInterval = true;
            }
            errorCount++;
        }
        else
        {
            clearInterval(sm);
        }
    }
}

function runSessionManagement()
{
    var sm = setInterval(sessionManagement, minutesToCheck * 6000);  //setInterval runs in microseconds, so 60,000 microseconds = 60 seconds
}


runSessionManagement(); //Actually execute the function....