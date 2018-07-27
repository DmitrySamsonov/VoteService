INSERT INTO options (link, method, description)
VALUES
  ('http://localhost:8090/rest/voting/create', 'POST',
   'generate voting JSON and send HTTP-request for create voting'),


  ('http://localhost:8090/rest/voting/{votingId}/start', 'GET',
   'send HTTP-request with voting ID for start voting and get generated link.'),


  ('http://localhost:8090/rest/voting/{votingId}/stop', 'GET',
   'send HTTP-request with voting ID for stop voting.'),


  ('http://localhost:8090/rest/voting/{votingId}/', 'GET',
   'send HTTP-request with voting ID for get voting statistic.'),


  ('http://localhost:8090/rest/voting/{votingId}/{answerId}', 'GET',
   'send HTTP-request with voting ID for get answer statistic.'),


  ('http://localhost:8090/rest/voting/{votingId}/answers', 'POST',
   'send HTTP-request with voting ID and selected answers Id for selected answers in voting.'),


  ('http://localhost:8090/', 'OPTIONS', 'get REST API OPTIONS'),


  ('http://localhost:8090/rest/voting/{votingId}/ui', 'GET',
   'send HTTP-request with voting ID for get voting statistic in USER INTERFACE.'),


  ('http://localhost:8090/rest/voting/answers/ui', 'POST',
   'generate answers ID List and voting ID and send to server for selected votes in USER INTERFACE.');
