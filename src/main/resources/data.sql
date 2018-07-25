INSERT INTO options (link, method, description)
VALUES
  ('http://localhost:8090/rest/voting/create', 'POST', 'generate voting JSON and send HTTP-request for create voting'),
  ('http://localhost:8090/rest/voting/{votingId}/start', 'GET','send HTTP-request with voting ID for start voting.'),
  ('http://localhost:8090/rest/voting/{votingId}/stop', 'GET','send HTTP-request with voting ID for stop voting.'),
  ('http://localhost:8090/rest/voting/{votingId}/link', 'GET','send HTTP-request with voting ID for get voting link.'),
  ('http://localhost:8090//voting/{votingId}/', 'GET','send HTTP-request with voting ID for get voting User Interface.'),
  ('http://localhost:8090//voting/answers/', 'POST','select answers in User interface and send to server for selected votes.'),
  ('http://localhost:8090/rest/voting/answers', 'POST','generate answers ID List and voting ID and send to server for selected votes.'),
  ('http://localhost:8090/', 'OPTIONS','get REST API OPTIONS');