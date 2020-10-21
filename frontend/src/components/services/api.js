import axios from 'axios';
import { getToken } from "./auth";

// INSIRA SEU IP EM 'baseURL'
const api = axios.create({ baseURL: 'http://10.0.0.167:8080/'});

api.interceptors.request.use(async config => {
    const token = getToken();
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  });
export default api;