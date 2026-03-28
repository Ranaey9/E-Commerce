import 'package:e_ticaret/loginScreen/Apple_screen.dart';
import 'package:e_ticaret/loginScreen/google_screen.dart';
import 'package:e_ticaret/loginScreen/login_screen.dart';
import 'package:e_ticaret/loginScreen/signUp_screen.dart';
import 'package:flutter/material.dart';


void main() {
  runApp(const MyApp());
}
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Shop Store',
      initialRoute: '/',
      routes: {
        '/': (context) => const LoginScreen(),
        '/signup': (context) => const SignUpScreen(),
        '/googleScreen': (context) => const GoogleScreen(),
        '/AppleScreen': (context) => const AppleScreen(),
      },
    );
  }
}