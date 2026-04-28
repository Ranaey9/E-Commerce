class UserModel {
  String? name;
  String? surname;
  String? email;
  String? password;

  UserModel({this.name, this.surname, this.email, this.password});

  Map<String, dynamic> toJson() {
    return {
      "name": name,
      "surname": surname,
      "email": email,
      "password": password,
    };
  }
}
