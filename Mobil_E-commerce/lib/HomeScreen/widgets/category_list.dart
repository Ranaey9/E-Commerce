import 'package:e_commerce/l10n/app_localizations.dart';
import 'package:flutter/material.dart';

class CategoryList extends StatelessWidget {
  final bool isWoman;

  const CategoryList({super.key, required this.isWoman});

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;

    final List<Map<String, dynamic>> categories = isWoman
        ? [
            {'title': l10n.dresses},
            {'title': l10n.clothing},
            {'title': "${l10n.shoes} & ${l10n.bags}"},
            {'title': l10n.cosmetics},
            {'title': l10n.lingerie},
          ]
        : [
            {'title': l10n.tshirts},
            {'title': l10n.pants},
            {'title': l10n.outerwear},
            {'title': l10n.shoes},
            {'title': l10n.watches},
          ];
    return Column(
      children: categories.map((cat) {
        return Container(
          decoration: const BoxDecoration(
            border: Border(
              bottom: BorderSide(color: Color(0xFFEEEEEE), width: 1),
            ),
          ),
          child: ListTile(
            contentPadding: const EdgeInsets.symmetric(
              horizontal: 25,
              vertical: 2,
            ),
            title: Text(
              cat['title'],
              style: const TextStyle(
                fontSize: 15,
                fontWeight: FontWeight.w400,
                color: Colors.black87,
              ),
            ),
            trailing: const Icon(
              Icons.arrow_forward_ios,
              size: 14,
              color: Colors.grey,
            ),
            onTap: () => Navigator.pop(context),
          ),
        );
      }).toList(),
    );
  }
}
