import 'package:e_commerce/l10n/app_localizations.dart';
import 'package:flutter/material.dart';

class FavoritesScreen extends StatelessWidget {
  const FavoritesScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;

    return Scaffold(
      backgroundColor: Colors.white,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Icon(Icons.favorite_border, size: 80, color: Color(0xFF2B2E81)),
            const SizedBox(height: 15),
            Text(
              l10n.favorites,
              style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Color(0xFF2B2E81)),
            ),
          ],
        ),
      ),
    );
  }
}