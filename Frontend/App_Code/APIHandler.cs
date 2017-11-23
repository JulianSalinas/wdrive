﻿
using System;
using System.IO;
using WDrive;

namespace API
{
    public static class APIHandler
    {

        private static WDriveApiService _api;

        private static WDriveApiService getApi()
        {
            if (_api != null)
                return _api;
            else
                _api = new WDriveApiService();

            return _api;
        }

        public static string loadAccount(string UserName, string Password)
        {
            return getApi().loadAccount(UserName, Password);
        }

        public static string createAccount(string UserName, string Password, int bytes)
        {
            return getApi().createAccount(UserName, Password, (long) bytes);
        }

        public static void generartxt(string msg)
        {
            string[] lines = { msg };

            // Set a variable to the My Documents path.
            string mydocpath =
                Environment.GetFolderPath(Environment.SpecialFolder.Desktop);

            // Write the string array to a new file named "WriteLines.txt".
            using (StreamWriter outputFile = new StreamWriter(mydocpath + @"\respuesta.txt"))
            {
                foreach (string line in lines)
                    outputFile.WriteLine(line);
            }
        }
    }
}