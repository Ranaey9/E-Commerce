import 'package:flutter/material.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Colors.white,
        actions: [
          IconButton(
            onPressed: () {},
            icon: const Icon(Icons.notifications, color: Colors.black),
            iconSize: 30,
          ),
          const SizedBox(width: 10), // En sağdan biraz boşluk bırakır
        ],
      ),
      body: const Center(child: Text("Home Content")),
    );
  }
}
