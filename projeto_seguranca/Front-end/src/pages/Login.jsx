import LogoForm from "../components/LogoForm.jsx";
import { useState } from "react";
import { FaUser, FaLock } from "react-icons/fa";
import { Link } from "react-router-dom";

function Login() {
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Dados recibidos:", { name, password });
  };

  return (
    <div className="flex justify-center items-center h-screen  gap-4">
      <div className="bg-white w-120 h-140 flex flex-col  items-center border  border-[#BBF7D0] border shadow rounded-sm ">
        <LogoForm subtitle="Faça login para acessar o sistema" />

        <form onSubmit={handleSubmit}>
          <div className="flex flex-col gap-4 w-100 mt-10 mb-6">
            <label className="text-gray-600" htmlFor="name">
              Nome
            </label>
            <div className="flex h-12 items-center border border-gray-200 rounded-md px-2 py-1 gap-2">
              <FaUser className="ml-2 text-gray-400" />
              <input
                className="outline-none ring-0 focus:outline-none focus:ring-0"
                type="text"
                placeholder="Insira seu nome"
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
            </div>

            <label className="text-gray-600" htmlFor="password">
              Senha
            </label>
            <div className="flex h-12 items-center border border-gray-200 rounded-md px-2 py-1 gap-2">
              <FaLock className="ml-2 text-gray-400" />
              <input
                className="outline-none ring-0 focus:outline-none focus:ring-0"
                type="password"
                placeholder="Insira sua senha"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>

            <button
              className="bg-blue-600 text-white rounded-lg p-2 hover:bg-blue-700 transition-colors w-full mt-4 mb-6"
              type="submit"
            >
              Entrar
            </button>
          </div>

          <div className="flex justify-center items-center flex-col ">
            <p className="text-sm text-gray-600">Não tem uma conta? </p>
            <Link
              to="/cadastro"
              className=" text-blue-600 text-sm hover:text-blue-800 transition-colors"
            >
              Cadastre-se aqui
            </Link>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
