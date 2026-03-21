import 'package:flutter/material.dart';

class ForgotPasswordScreen extends StatefulWidget {
  const ForgotPasswordScreen({super.key});

  @override
  State<ForgotPasswordScreen> createState() => _ForgotPasswordScreenState();
}

class _ForgotPasswordScreenState extends State<ForgotPasswordScreen> {
  final TextEditingController _emailController = TextEditingController();

  void resetPassword() {
    String email = _emailController.text.trim();

    if (email.isEmpty) {
      ScaffoldMessenger.of(
        context,
      ).showSnackBar(const SnackBar(content: Text("Please enter your email.")));
    } else {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text("Reset link sent to your email.")),
      );

      Navigator.pop(context);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,

      appBar: AppBar(
        elevation: 0,
        backgroundColor: Colors.white,
        iconTheme: const IconThemeData(color: Color(0xFF2B2E81)),
      ),

      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 25),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const SizedBox(height: 20),

            const Text(
              "Forgot Password",
              style: TextStyle(
                fontSize: 26,
                fontWeight: FontWeight.bold,
                color: Color(0xFF2B2E81),
              ),
            ),

            const SizedBox(height: 10),

            const Text(
              "Enter your email and we will send you a password reset link.",
              style: TextStyle(color: Colors.grey),
            ),

            const SizedBox(height: 30),

            // EMAIL
            TextField(
              controller: _emailController,
              keyboardType: TextInputType.emailAddress,
              cursorColor: const Color(0xFF2B2E81),
              decoration: InputDecoration(
                labelText: "E-mail",
                filled: true,
                fillColor: const Color(0xFFF5F5F7),
                enabledBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(15),
                  borderSide: BorderSide.none,
                ),
                focusedBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(15),
                  borderSide: const BorderSide(
                    color: Color(0xFF2B2E81),
                    width: 1.5,
                  ),
                ),
              ),
            ),

            const SizedBox(height: 30),

            // BUTTON
            InkWell(
              onTap: resetPassword,
              borderRadius: BorderRadius.circular(15),
              child: Container(
                height: 55,
                decoration: BoxDecoration(
                  color: const Color(0xFF2B2E81),
                  borderRadius: BorderRadius.circular(15),
                ),
                child: const Center(
                  child: Text(
                    "Send Reset Link",
                    style: TextStyle(
                      color: Colors.white,
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
