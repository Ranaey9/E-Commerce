import 'package:e_commerce/HomeScreen/home_screen.dart';
import 'package:e_commerce/l10n/app_localizations.dart';
import 'package:e_commerce/language_provider.dart';
import 'package:e_commerce/loginScreen/Apple_screen.dart';
import 'package:e_commerce/loginScreen/google_screen.dart';
import 'package:e_commerce/loginScreen/login_screen.dart';
import 'package:e_commerce/loginScreen/signUp_screen.dart';
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (context) => LanguageProvider(),
      child: const MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    final languageProvider = Provider.of<LanguageProvider>(context);

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      locale: languageProvider.currentLocale,
      supportedLocales: const [Locale('tr'), Locale('en')],
      localizationsDelegates: const [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      initialRoute: '/',
      routes: {
        '/': (context) => const LoginScreen(),
        '/HomeScreen': (context) => const HomeScreen(),
        '/signup': (context) => const SignUpScreen(),
        '/googleScreen': (context) => const GoogleScreen(),
        '/AppleScreen': (context) => const AppleScreen(),
      },
    );
  }
}
