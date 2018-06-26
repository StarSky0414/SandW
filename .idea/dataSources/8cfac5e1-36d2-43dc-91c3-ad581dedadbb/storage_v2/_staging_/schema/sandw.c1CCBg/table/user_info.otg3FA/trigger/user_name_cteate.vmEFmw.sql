create trigger user_name_cteate
  after INSERT
  on user_info
  for each row
  BEGIN
  update user_info set user_name=OLD.id;
end;

