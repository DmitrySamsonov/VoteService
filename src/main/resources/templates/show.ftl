<!DOCTYPE html>
<html>
<head>
    <title>Message</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<p>
    <#--Voting Id: ${voting.getVotingId()}-->
    <br>
    Theme Name: ${voting.getVotingTheme()}
    <br>
    Question: ${voting.getQuestion()}
    <br>
    Answers:
<form action="/rest/voting/${voting.getVotingId()}/answers/ui" method="post">
    <input hidden="hidden" type="text" name="votingId" value="${voting.getVotingId()}"/>
    <table border=1 >
    <tr>
    <#--<td> id-->
        <td> name
        <td> count
    <td> selected
    <#list voting.getAnswers() as answer>
    <tr>
    <#--<td> ${answer.getAnswerId()}-->
        <td> ${answer.getAnswerName()}
        <td> ${answer.getCount()}
    <td> <input type="checkbox" list="fruits" name="selectedAnswersId" value="${answer.getAnswerId()}">
    </#list>
    </table>
    <br><br>
    <input type="submit" value="send selected votes"/>
</form>

</p>


</body>
</html>