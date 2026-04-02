// ignore: unused_import
import 'package:intl/intl.dart' as intl;
import 'app_localizations.dart';

// ignore_for_file: type=lint

/// The translations for Turkish (`tr`).
class AppLocalizationsTr extends AppLocalizations {
  AppLocalizationsTr([String locale = 'tr']) : super(locale);

  @override
  String get search => 'Ara ...';

  @override
  String get login => 'Giriş Yap';

  @override
  String get email => 'E-posta';

  @override
  String get password => 'Şifre';

  @override
  String get or => 'VEYA';

  @override
  String get continueWithGoogle => 'Google ile Devam Et';

  @override
  String get continueWithApple => 'Apple ile Devam Et';

  @override
  String get dontHaveAccount => 'Hesabınız yok mu?';

  @override
  String get signUp => 'Kayıt Ol';

  @override
  String get errorEmptyFields => 'Lütfen e-posta ve şifrenizi giriniz.';
}
