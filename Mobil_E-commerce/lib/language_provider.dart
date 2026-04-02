import 'package:flutter/material.dart';

class LanguageProvider extends ChangeNotifier {
  Locale _currentLocale = const Locale('tr');

  Locale get currentLocale => _currentLocale;

  void changeLanguage(String langCode) {
    _currentLocale = Locale(langCode);
    notifyListeners();
  }
}
