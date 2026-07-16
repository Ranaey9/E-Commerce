import 'package:e_commerce/l10n/app_localizations.dart';
import 'package:flutter/material.dart';

class ProfileScreen extends StatelessWidget {
  const ProfileScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context)!;

    return Scaffold(
      backgroundColor: const Color(0xFFF5F5F7),
      appBar: AppBar(
        title: Text(
          l10n.profile,
          style: const TextStyle(
            color: Color(0xFF2B2E81),
            fontWeight: FontWeight.bold,
          ),
        ),
        backgroundColor: Colors.white,
        elevation: 0,
        centerTitle: false,
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            const SizedBox(height: 20),
            Container(
              margin: const EdgeInsets.symmetric(horizontal: 20),
              padding: const EdgeInsets.all(20),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(20),
                boxShadow: [
                  BoxShadow(
                    color: Colors.black.withOpacity(0.02),
                    blurRadius: 10,
                    offset: const Offset(0, 5),
                  ),
                ],
              ),
              child: Row(
                children: [
                  CircleAvatar(
                    radius: 35,
                    backgroundColor: const Color(0xFF2B2E81).withOpacity(0.1),
                    child: const Icon(
                      Icons.person,
                      size: 40,
                      color: Color(0xFF2B2E81),
                    ),
                  ),
                  const SizedBox(width: 20),
                  const Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "Rana Ayoub",
                        style: TextStyle(
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                          color: Color(0xFF2B2E81),
                        ),
                      ),
                      SizedBox(height: 4),
                      Text(
                        "name@example.com",
                        style: TextStyle(fontSize: 14, color: Colors.grey),
                      ),
                    ],
                  ),
                ],
              ),
            ),
            const SizedBox(height: 25),

            Container(
              margin: const EdgeInsets.symmetric(horizontal: 20),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(20),
                boxShadow: [
                  BoxShadow(
                    color: Colors.black.withOpacity(0.02),
                    blurRadius: 10,
                    offset: const Offset(0, 5),
                  ),
                ],
              ),
              child: Column(
                children: [
                  _buildProfileMenuItem(
                    icon: Icons.shopping_bag_outlined,
                    title: "Siparişlerim",
                    onTap: () {},
                  ),
                  const Divider(height: 1, indent: 55, endIndent: 20),
                  _buildProfileMenuItem(
                    icon: Icons.location_on_outlined,
                    title: "Adres Bilgilerim",
                    onTap: () {},
                  ),
                  const Divider(height: 1, indent: 55, endIndent: 20),
                  _buildProfileMenuItem(
                    icon: Icons.credit_card_outlined,
                    title: "Kayıtlı Kartlarım",
                    onTap: () {},
                  ),
                  const Divider(height: 1, indent: 55, endIndent: 20),
                  _buildProfileMenuItem(
                    icon: Icons.settings_outlined,
                    title: "Ayarlar",
                    onTap: () {},
                  ),
                  const Divider(height: 1, indent: 55, endIndent: 20),
                  _buildProfileMenuItem(
                    icon: Icons.logout_outlined,
                    title: "Çıkış Yap",
                    iconColor: Colors.red,
                    textColor: Colors.red,
                    onTap: () {
                      Navigator.pushNamedAndRemoveUntil(
                        context,
                        '/',
                        (route) => false,
                      );
                    },
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildProfileMenuItem({
    required IconData icon,
    required String title,
    required VoidCallback onTap,
    Color iconColor = const Color(0xFF2B2E81),
    Color textColor = Colors.black87,
  }) {
    return ListTile(
      leading: Icon(icon, color: iconColor),
      title: Text(
        title,
        style: TextStyle(
          color: textColor,
          fontSize: 15,
          fontWeight: FontWeight.w500,
        ),
      ),
      trailing: const Icon(
        Icons.arrow_forward_ios,
        size: 16,
        color: Colors.grey,
      ),
      onTap: onTap,
    );
  }
}
